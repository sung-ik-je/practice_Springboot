



// react의 함수 component
function MyButton(props){
    const [isCliked, setIsClicked] = React.useState(false);

    return React.createElement(
        'button',
        { onClick: () => setIsClicked(true)},
        isCliked ? 'clicked!' : 'Click here!'
    )

}

// react component를 dom container에 렌더링하는 함수
// script를 이용해 component를 가져와도 component가 바로 사용되는 것이 아니기 때문
const domContainer = document.querySelector('#root');
ReactDOM.render(React.createElement(MyButton), domContainer);