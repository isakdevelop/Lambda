-- 001. 전체 축구팀 목록을 팀 이름 오름차 순으로 출력하시오.
select team_name as 팀_이름 from team order by team_name;

-- 002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈 공간으로 두시오.
select distinct POSITION as 포지션 from player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오.
select distinct ifnull(nullif(POSITION, ''), '신입') as 포지션 from player;

select distinct
    (case
         when POSITION = '' then '신입'
         else POSITION
        end) as 포지션
from player;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
select player_name as 수원_골키퍼_이름 from player where team_id = 'k02' and POSITION = 'GK';

-- 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오.
select player_name as 골키퍼_이름 from player where team_id = (select team_id from team where region_name = '수원') and
    POSITION = 'GK';

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
select player_name as 고씨_성의_170이_넘는_수원_선수 from player
where team_id = 'k02' and player_name like '고%' and height >= 170;

select * from player where (select team_id from team where region_name = '수원') = team_id and player_name like '고%'
                       and height >= 170;

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

SELECT player_name
FROM player
WHERE team_id IN (SELECT team_id FROM team WHERE team_name = '삼성블루윙즈' OR team_name = '드래곤즈')
  AND POSITION = 'MF'
  AND height BETWEEN 170 AND 180;


-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
select player_name from player where POSITION = 'GK' and team_id = (select team_id
                                                                    from team
                                                                    where region_name = '수원');

-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT
    player_name,
    IFNULL(nullif(height, ''), '0') AS height,
    IFNULL(nullif(weight, ''), '0') AS weight
FROM
    player
WHERE
    team_id = (SELECT team_id
               FROM team
               WHERE region_name = '서울')
ORDER BY
    height DESC,
    weight DESC;

-- 문제 9-- 서울팀 선수들 이름과 포지션과 키(cm표시)와 몸무게(kg표시)와 각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오

SELECT
    player_name,
    POSITION,
    CONCAT(IFNULL(NULLIF(height, ''), '0'), 'cm') AS height,
    CONCAT(IFNULL(NULLIF(weight, ''), '0'), 'kg') AS weight,
    ifnull(
            ROUND(weight / ((height / 100) * (height / 100)), 1),
            'NONE') as bmi
FROM
    player
WHERE
    team_id = (SELECT team_id
               FROM team
               WHERE region_name = '서울')
ORDER BY
    player_name DESC;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
select p.player_name, t.region_name
from player p
         join team t on p.team_id = t.team_id
where p.team_id in ('K02', 'K10')
  and p.POSITION = 'GK'
ORDER BY t.region_name, p.player_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select t.region_name, t.team_name, s.stadium_name
from team t
         join stadium s on t.stadium_id = s.stadium_id;


-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
select p.height, t.team_name, p.player_name
from player p
         join team t on p.team_id = t.team_id
where p.team_id in ('K02', 'K10') and p.height between 180 and 183
order by p.height, t.team_name, p.player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순

-- 스칼라 사용
select
    (select team_name
     from team
     where team_id = p.team_id) as team_name, p.player_name
from player p
where p.POSITION = ''
order by team_name, p.player_name;

-- 조인 사용
select t.team_name, p.player_name
from player p
         join team t on p.team_id = t.team_id
where p.POSITION = ''
order by t.team_name, p.player_name;

-- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
select
    t.team_name as 팀_명,
    sta.stadium_name as 스타디움_명,
    (select team_name
     from team
     where team_id = sch.awayteam_id) as 어웨이_팀_명
from
    schedule sch
        join
    team t on sch.hometeam_id = t.team_id
        join
    stadium sta on sch.stadium_id = sta.stadium_id
where
    sch.sche_date = '20120317';

-- 조인이 1번인 경우
select
    (select team_name
     from team
     where team_id = sta.hometeam_id) as 팀_명,
    sta.stadium_name as 스타디움_명,
    (select team_name
     from team
     where team_id = sch.awayteam_id) as 어웨이_팀_명
from
    schedule sch
        join
    stadium sta on sch.stadium_id = sta.stadium_id
where
    sch.sche_date = '20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)

select
    p.player_name as 선수명,
    p.position as 포지션,
    CONCAT(t.region_name, ' [', t.team_name, ']') as 팀명,
    s.stadium_name as 스타디움,
    sch.sche_date as 경기날짜
from
    player p
        join
    team t on p.team_id = t.team_id
        join
    stadium s on t.stadium_id = s.stadium_id
        join
    schedule sch on t.team_id = sch.hometeam_id
where
    p.position = 'GK'
  and t.team_name = '스틸러스'
  and sch.sche_date = '20120317';

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오

select (select stadium_name
        from stadium
        where stadium_id = sch.stadium_id) as 경기장_이름, sch.sche_date as 경기_일정,
       sch.hometeam_id as 홈팀_이름, sch.awayteam_id as 원정팀_이름
from schedule sch
where sch.home_score - sch.away_score >= 3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름, 홈팀 출력, 없으면 null

select s.stadium_name as 운동장, t.team_name as 홈팀
from stadium s
         left join team t on s.hometeam_id = t.team_id;

-- 학습용
select s.stadium_name, t.team_name
from stadium s
         left join team t using(stadium_id);

-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력
select * from player limit 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
SELECT team_id,team_name,ROUND(AVG(p.height),2)
FROM team t
         JOIN player p USING (team_id)
WHERE height !=' '
GROUP BY team_id
HAVING ROUND(AVG(p.height),2)< 176.59;

select
    t.team_id as 팀ID,
    t.team_name as 팀명,
    round(avg(case when p.height > 0 then p.height else 0 end),2) as 평균키
from
    team t
        join
    player p using(team_id)
group by
    t.team_id
having
    평균키 < (select round(avg(case when height > 0 then height else 0 end),2) from player where team_id = 'K04');


-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
select (select team_name
        from team
        where team_id = p.team_id) as 소속팀명, p.player_name, p.back_no
from player p
where p.POSITION = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외

select t.team_name as 소속팀명, p.player_name as 선수명, p.back_no as 백넘버
from player p
         join team t using (team_id)
where p.height != ''
order by p.height desc
    limit 5;

select (select team_name
        from team
        where team_id = p.team_id) as 소속팀명, p.player_name as 선수명, p.back_no as 백넘버
from player p
where p.height != ''
order by p.height desc
    limit 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)

select p.player_name as 선수명, case when p.height > 0 then p.height else 0 end as 선수_키
from player p
         join team t using (team_id)
         join (
    select t.team_id,
           round(AVG(p.height),2) as 팀_평균키
    from
        team t
            join
        player p using (team_id)
    group by
        t.team_id
) as 팀과평균키 using (team_id)
where p.height < 팀과평균키.팀_평균키;


-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
select s.stadium_name
from stadium s
         left join schedule sch using(stadium_id)
where sch.sche_date like '201205%'
group by s.stadium_name;

select (select stadium_name
        from stadium
        where stadium_id = schedule.stadium_id)
from schedule
where sche_date like '201205%';