import React from "react";
import Notification from "./Notification";

const reservedNotifications =[
    {
        id: 1,
        message: "안녕하세요, 오늘 일정을 알려드립니다.",
    },
    {
        id: 2,
        message: "점심식사 시간입니다.",
    },
    {
        id: 3,
        message: "이제 곧 미팅이 시작됩니다.",
    },
    {
        id: 4,
        message: "추가 테스트 입니다.",
    },
];

var timer;
class NotificationList extends React.Component{
    constructor(props){
        super(props);

        // state 선언
        // 앞으로 사용할 데이터 state에 넣어 초기화
        this.state = {
            notifications: [],
        };
    }

    /*
    1초마다 정해진 작업 실행
    작업 :
        reservedNotifications(미리 만들어 놓은 알림 데이터 배열)에서
            알림 데이터 하나씩 가져와서 state에 notification에 업데이트(setState 함수 이용)
    */
    componentDidMount(){
        const { notifications } = this.state;
        timer = setInterval(() => {
            if(notifications.length < reservedNotifications.length){
                const index = notifications.length;
                notifications.push(reservedNotifications[index]);
                this.setState({
                    notifications: notifications,
                });
            }else{
                clearInterval(timer);
            }
        }, 1000);
    }
    
    render(){
        return(
            <div>
                {this.state.notifications.map((notification) => {
                    return (
                        <Notification 
                            key={notification.id}
                            id={notification.id} 
                            message={notification.message} 
                        />
                    );
                })}
            </div>
        )
    }
}

export default NotificationList;




