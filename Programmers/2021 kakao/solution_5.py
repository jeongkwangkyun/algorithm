# 프로그래머스 광고삽입
# 0부터 play_time +1 까지 0으로 초기화한 뒤
# 문자열 시간을 숫자로 바꿔서 리스트 시작과 끝에 1, -1
# 

def str_to_int(time):
    h,m,s=time.split(':')
    return int(h)*3600+int(m)*60+int(s)

def int_to_str(time):
    h=time//3600
    h='0'+str(h) if h<10 else str(h)
    time=time%3600
    m=time//60
    m='0'+str(m) if m<10 else str(m)
    time=time%60
    
    s='0'+str(time) if time<10 else str(time)
    
    return h+':'+m+':'+s

def solution(play_time, adv_time, logs):
    
    play_time=str_to_int(play_time)
    adv_time=str_to_int(adv_time)
    all_time=[0 for i in range(play_time+1)]
    #log 들을 따서 start, end에 1,-1 표시
    for i in logs:
        start,end=i.split('-')
        start=str_to_int(start)
        end=str_to_int(end)
        all_time[start]+=1
        all_time[end]-=1
    # start, end에 사이 빈 곳을 메꾸는 용도
    for i in range(1,len(all_time)):
        all_time[i]=all_time[i]+all_time[i-1]
    # log들의 중복값을 더하는 용도
    for i in range(1,len(all_time)):
        all_time[i]=all_time[i]+all_time[i-1]

    most_view=0
    max_time=0

    for i in range(adv_time-1,play_time):

        if i >=adv_time:
            # i부터 i-adv_time까지 most_view가 큰게 있으면 값 바꿔줌
            if most_view<all_time[i]-all_time[i-adv_time]:
                most_view=all_time[i]-all_time[i-adv_time]
                max_time=i-adv_time+1
        # adv_time-1 부터 시작해서 max time을 adv_time 길이까지 설정
        else:
            if most_view<all_time[i]:
                most_view=all_time[i]
                max_time=i-adv_time+1

    return int_to_str(max_time)

