package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.List;

public class P469Ex01 {
	// ArrayList�� �̿��� ���ű�, ����, �ٶ���, �󸶸� ���ҷ� �Է� �� 
	// �� ���ҿ��� ũ�Ⱑ 2�� �ܾ ���
	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("���ű�");
		nameList.add("����");
		nameList.add("�ٶ���");
		nameList.add("��");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).length() == 2) {
				System.out.println(nameList.get(i).toString());
			}
		}
	}
}
