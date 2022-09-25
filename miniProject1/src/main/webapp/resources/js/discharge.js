$("button[class='dischargeCalc']").on("click", function name() {
	let dateExp = /^\d{4}-\d{2}-\d{2}$/;
	let endYear = 0;
	let endDate = 0;
	let endMonth = 0;
	let lastDayInfo = 0;
	let totalMonth = "";
	let totalDate = "";
	const start = $("#start-day").val();
	let startYear = parseInt(start.substr(0, 4));
	let startMonth = parseInt(start.substr(5, 2));
	let startDate = parseInt(start.substr(8, 2));
	
	if($("#start-day").val() == ""){
		alert("복무 시작일을 입력해 주세요");
		return false;
	}
	else if(!dateExp.test($("#start-day").val())){
		alert("날짜 형식에 맞지 않습니다.")
		return false;
	}
	else if(startYear < 1932){
		alert("이세상 사람이 아니시군요?")
		return false;
	}
	else if(startYear > 2025){
		alert("미래에서 오셨나요?")
		return false;
	}
	else if(startMonth < 1 || startMonth > 12){
		alert("날짜 형식에 맞지 않습니다.")
		return false;
	}
	else if(startDate < 1 || startDate > 30){
		alert("날짜 형식에 맞지 않습니다.")
		return false;
	}
	else {
		
		if($("select[name='soldier']").val() == "육군") { 
			// 육군 545일	
			lastDayInfo = startDate + 545;
		} 
		else if($("select[name='soldier']").val() == "해군") { 
			// 해군 606일
			lastDayInfo = startDate + 606;
		} 
		else if($("select[name='soldier']").val() == "공군") { 
			// 공군 637일
			lastDayInfo = startDate + 637;
		}
		else if($("select[name='soldier']").val() == "해병대") { 
			// 해병대 545일
			lastDayInfo = startDate + 545;
		}
		else if($("select[name='soldier']").val() == "의무경찰") { 
			// 의경 545일
			lastDayInfo = startDate + 545;
		}
		else if($("select[name='soldier']").val() == "해양의무경찰"){
			// 해경 606일
			lastDayInfo = startDate + 606;
		}
		else if($("select[name='soldier']").val() == "의무소방"){
			// 의소 545일
			lastDayInfo = startDate + 545;
		}
		else if($("select[name='soldier']").val() == "사회복무요원"){
			// 공익 545일
			lastDayInfo = startDate + 545;
		}
		
		lastYear = parseInt(lastDayInfo / 365);
		lastMonth = parseInt(parseInt(lastDayInfo % 365) / 30)
		lastDate = parseInt(lastDayInfo % 30);
		endDate = startDate + lastDate;
		endMonth = startMonth + lastMonth;
		endYear = startYear + lastYear;	
		if(endDate > 30){
			endDate = parseInt(endDate % 30)
			endMonth = endMonth + 1;
		}
		if(endMonth > 12){
			endMonth = parseInt(endMonth % 12)
			endYear = endYear + 1;
		}
		
		if(endMonth < 10){
			totalMonth = "0" + endMonth.toString();
		}
		else {
			totalMonth = endMonth.toString();
		}
		if(endDate < 10){
			totalDate = "0" + endDate.toString();
		}
		else {
			totalDate = endDate.toString();
		}
        const end = endYear.toString() + "-" + totalMonth + "-" + totalDate;
        const rtn_ymd = day => {
            return day.getFullYear()+'년 '+(day.getMonth()+1)+'월 '+day.getDate()+'일';
        }
        const rtn_day = (now, end) => {
            let gap = now.getTime() - end.getTime();
            return Math.floor(gap / (1000 * 60 * 60 * 24)) * -1;
        }
        const get_id = id => {
            return document.getElementById(id);
        }

        const now = new Date();
        const s_day = new Date(start+'T00:00:00');
        const e_day = new Date(end+'T00:00:00');

        const tot_day = rtn_day(s_day,e_day);
        const remining_day = rtn_day(now,e_day);

        const remining_time = remining_day * 24;
        let total = remining_day / tot_day * 100;
        total = 100 - total;
		
		get_id('start-day').innerHTML = rtn_ymd(s_day);
        get_id('end-day').innerHTML = rtn_ymd(e_day);
        get_id('now-day').innerHTML = rtn_ymd(now);
        
        get_id('day-progress').style.width = total + '%';
        get_id('total-day').innerHTML = tot_day + '일';
        if(remining_time < 0){
			get_id('rem-time').innerHTML = tot_day + "일 간"
		} else {
			get_id('rem-time').innerHTML = '약 ' + remining_time + '시간';
		}
        if(remining_day < 0){
			get_id('rem-day').innerHTML = "조국을 위해 헌신해 주신 장병님"
		} else {
			get_id('rem-day').innerHTML = remining_day + '일';
		}
        if(remining_day/7 < 0 || remining_day%7 == 0){
			get_id('rem-week').innerHTML = "진심으로 전역을 축하드립니다."
		} else {
        	get_id('rem-week').innerHTML = parseInt(remining_day/7) + '주 ' + remining_day%7 + '일';		
		}
        
        if(total < 100){
			get_id('per').innerHTML = total + '%';
		}
        else{
			get_id('per').innerHTML = "감사합니다.";
		}
	}
})

       
