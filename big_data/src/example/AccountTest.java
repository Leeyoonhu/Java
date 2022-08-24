package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
	private String accountId, accountPwd, userName;
	private int balance;
	public Account(String accountId, String accountPwd, String userName, int balance) {
		this.accountId = accountId;
		this.accountPwd = accountPwd;
		this.userName = userName;
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getAccountPwd() {
		return accountPwd;
	}
	public String getUserName() {
		return userName;
	}
	public int getBalance() {
		return balance;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", pwd=" + accountPwd + ", Name=" + userName
				+ ", balance=" + balance + "]";
	}
}

public class AccountTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String password = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		List<Account> aL = new ArrayList<Account>();
		String accountId = null;
		String accountPwd = null;
		String sendAccountId = null;
		int balance = 0;
		int balance2 = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EXIT:
		while(true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.계좌개설 | 2.입금 | 3.출금 | 4.송금 | 5.잔액조회 | 6.전체계좌조회 | 7.프로그램종료");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요>> ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				try {
					System.out.print("계좌번호, 비밀번호, 이름, 최초 입금액을 입력하세요>>");
					sql = "insert into Account values (?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, scan.next());
					pstmt.setString(2, scan.next());
					pstmt.setString(3, scan.next());
					pstmt.setInt(4, scan.nextInt());
					pstmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.print("계좌와 입금액을 입력하세요>>");
					accountId = scan.next();
					int plusMoney = scan.nextInt();
					sql = "select balance from Account where accountId = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, accountId);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						balance = rs.getInt(1);
					}
					sql = "update Account set balance = ? where accountId = ?";
					pstmt = conn.prepareStatement(sql);
					if(plusMoney <= 0) {
						System.out.println("1원 이상 입금해주세요.");
					}
					else {
						pstmt.setInt(1, balance + plusMoney);
						pstmt.setString(2, accountId);
						pstmt.executeLargeUpdate();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.print("계좌번호, 비밀번호, 출금액을 입력하세요>> ");
					accountId = scan.next();
					accountPwd = scan.next();
					int minusMoney = scan.nextInt();
					sql = "select * from Account where accountId = ? and accountPwd = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, accountId);
					pstmt.setString(2, accountPwd);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						balance = rs.getInt(4);
						sql = "update Account set balance = ? where accountId = ?";
						pstmt = conn.prepareStatement(sql);
						if(balance < minusMoney) {
							System.out.println("잔액이 충분하지 않습니다.");
						}
						else {
							pstmt.setInt(1, balance - minusMoney);
							pstmt.setString(2, accountId);
							pstmt.executeLargeUpdate();
							sql = "select * from Account where accountId = ?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, accountId);
							rs = pstmt.executeQuery();
							while(rs.next()) {
								Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
								System.out.println(a.toString());
							}
						}
					}
					else {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;
			case 4:
				try {
					System.out.print("계좌번호, 비밀번호, 송금받을 계좌번호, 송금액을 입력하세요>>");
					accountId = scan.next();
					accountPwd = scan.next();
					sendAccountId = scan.next();
					int sendMoney = scan.nextInt();
					// 계좌 비번 같은지..
					if(accountId.equals(sendAccountId)) {
						System.out.println("자기 자신에게 송금할 수 없습니다.");
					}
					else {
						sql = "select * from Account where accountId = ? and accountPwd = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, accountId);
						pstmt.setString(2, accountPwd);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							balance = rs.getInt(4);
							if(balance < sendMoney) {
								System.out.println("잔액이 충분하지 않습니다.");
							}
							else {
								sql = "update Account set balance = ? where accountId = ?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setInt(1, balance - sendMoney);
								pstmt.setString(2, accountId);
								pstmt.executeUpdate();
								sql = "select * from Account where accountId = ?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, sendAccountId);
								rs = pstmt.executeQuery();
								while(rs.next()) {
									balance2 = rs.getInt(4);
								}
								sql = "update Account set balance = ? where accountId = ?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setInt(1, balance2 + sendMoney);
								pstmt.setString(2, sendAccountId);
								pstmt.executeUpdate();
								sql = "select * from Account where accountId = ? or accountId = ?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, accountId);
								pstmt.setString(2, sendAccountId);
								rs = pstmt.executeQuery();
								while(rs.next()) {
									Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
									System.out.println(a.toString());
								}
							}
						}
						else {
							System.out.println("비밀번호가 일치하지 않습니다.");
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;
			case 5:
				try {
					System.out.print("계좌번호와 비밀번호를 입력하세요 >>");
					sql = "select * from Account where accountId = ? and accountPwd = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, scan.next());
					pstmt.setString(2, scan.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.printf("%s의 잔액은 %d원 입니다.\n", rs.getString(1), rs.getInt(4));
					}
					else {
						System.out.println("입력하신 계좌번호나 비밀번호가 맞지 않습니다. 다시 입력해주세요");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				try {
					sql = "Select * from Account";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						System.out.println(a.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				break EXIT;
			}
		}
	}
}
