/*mblock
aduino 비접촉 온도센서를 이용해 측정한 결과 값과 mblock에서 인식한 값 두 가지를 이용해 하드웨어 및 음성 제어
# not implemented, yet의 경우 mblock 내에서 정의 내린 작업들 나타냄

# not implemented, yet
*/
sprite.play('Doorbell')
//사용 값 초기화
sprite.say(str(str('측정온도는 ') + str(#)) + str('도 입니다'))
# not implemented, yet  //측정온도는 음성출력
# not implemented, yet  //aduino 비접촉 온도센서 값
# not implemented, yet  //도 입니다 음성출력
sprite.set_variable('체온', #)   // aduino 비접촉 온도센서 이용한 온도 값
sprite.set_variable('인식결과', #)  //wabcam으로 입력받은 결과 값
//각 상황에 따른 조건문
if sprite.get_variable('인식결과') == '미착용':  //마스크 미착용
    # not implemented, yet
    sprite.play_until_done('Police Siren')  // 노트북 통해 음성 출력
    sprite.play_until_done('Police Siren')
    sprite.play_until_done('Police Siren')
    sprite.play_until_done('Police Siren')

if sprite.get_variable('인식결과') == '인식실패':  //얼굴인식 실패
    # not implemented, yet // 마스크 인식에 실패했다는 음성 출력

if sprite.get_variable('인식결과') == '착용' and # > 38: //마스크 착용 + 비정상온도
    # not implemented, yet // 고열환자 음성 출력
    sprite.play_until_done('Police Siren')
    sprite.play('Police Siren')
    sprite.play('Police Siren')

if sprite.get_variable('인식결과') == '착용' and # < 38: //마스크 착용 + 정상온도
    # not implemented, yet   // 마스크 착용, 적정 온도 표시 음성출력
    # not implemented, yet  // 문 통과 절차 음성출력
    # not implemented, yet  //aduino로 특정 신호 보내 servo motor 제어