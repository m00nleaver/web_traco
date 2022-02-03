# web_traco
웹 세미 프로젝트, 여행 예약 사이트 구현
진행기간 : 1/10~


## 기획
많은 기능을 구현해볼 수 있는 여행 예약 사이트로 결정하였습니다. <br>
그 중 코로나 19 상황으로 해외 여행이 여의치 않는 상황으로 국내 여행으로 한정하였습니다.<br>
국내 여행지를 선정할 때 갔던 곳, 알던 곳만 가던 개인의 경험들에 비추어 여행지 추천 기능을 추가하였습니다.

![image](https://user-images.githubusercontent.com/95206325/150713770-af4be572-3e00-496a-9ffe-a54dc9d17fa1.png)



## 벤치마킹
* 참고 사이트
> 여수시 / 나의 여행코스 만들기(https://www.yeosu.go.kr/tour/ybscript.io/itinerary_v2/index#) <br>
> 마이리얼트립 / 여행상품 중개 판매 플랫폼(https://www.myrealtrip.com/) <br>
> 유럽여행 계획 및 투어 판매 사이트(https://www.stubbyplanner.com/) <br>
> 대한민국 구석구석 / 국내 여행지 코스 공유(https://korean.visitkorea.or.kr/main/cs_main.do) <br>
> 야놀자 / 교통수단 연계 판매 기능(https://www.yanolja.com/train) <br>
> 노랑풍선 / 지역별, 테마별 패키지(https://www.ybtour.co.kr/product/localList.yb?menu=DMT&dspSid=ADAS000) <br>
> 유랑동행카페 / 커뮤니티(https://cafe.naver.com/firenze) <br>

유사한 주제의 사이트와 원하는 성격의 메뉴가 있는 사이트를 벤치마킹하였습니다. <br>
벤치마킹한 사이트는 분석을 통해 사이트의 방향성을 잡았습니다.
<br>
* 분석 내용의 일부
<br>

![image](https://user-images.githubusercontent.com/95206325/150711943-5c2bdb47-3336-4a7d-a187-0777d56df473.png)
![image](https://user-images.githubusercontent.com/95206325/150711970-1c7b60c7-0e09-49d4-b0b5-8bf6eea855cd.png)
![image](https://user-images.githubusercontent.com/95206325/150712068-1fb79c98-d8a8-40a2-a0cd-19d840de069c.png)


## 요구분석서
업무 분담과 협업이 필요한 팀프로젝트 특성상 자신의 업무와 타인의 업무까지 정확한 숙지가 필요했습니다. <br>
때문에 사전에 혼란을 방지하고자 최대한 자세히 작성하려 노력하였습니다.

<br>
* 요구 분석서 내용의 일부
<br>

![image](https://user-images.githubusercontent.com/95206325/150712531-1906d69c-2df6-4acb-91e8-15338d8660f0.png)

## 화면 설계 / 스토리보드
* 화면설계 : 발사믹 목업 와이어프레임
화면을 설계하는 단계에서 중요하게 생각했던 건 화면 전반의 통일성이였습니다. <br>
각 페이지마다 통일성을 주어 가독성을 높이고 추가적인 기능 습득 없이 페이지 접근과 화면 간의 전환이 가능하도록 구성하였습니다.

<img src="https://user-images.githubusercontent.com/95206325/150713040-2f6b998c-7962-492d-891f-759b2fc4e6b5.png" width="500" height="600">
<img src="https://user-images.githubusercontent.com/95206325/150713048-9b2c146d-b33b-4ee3-a921-8f4f240e709a.png" width="500" height="600">
<img src="https://user-images.githubusercontent.com/95206325/150713078-b738df4b-b1df-4fa4-93ff-2cf4957cf5c4.png" width="500" height="600">
<img src="https://user-images.githubusercontent.com/95206325/150713092-885ab12c-116d-42a7-a245-8953f620d031.png" width="500" height="600">

* 스토리보드
요구분석 단계와 마찬가지로 최대한 자세히 모든 기능에 대한 스토리보드를 작성하고자 노력하였습니다.

<img src="https://user-images.githubusercontent.com/95206325/150713607-22cf910b-24e3-453c-921d-b03276b0e04c.png" width="600" height="400">
<img src="https://user-images.githubusercontent.com/95206325/150713632-4e08121c-89e5-4751-9de6-126aa137dec9.png" width="600" height="400">


## 실제화면
* 배너 리스트 수정

<img src="https://user-images.githubusercontent.com/95206325/152370170-522b8028-86ee-4343-9833-3de9681a6aa3.png" width="600">

* 항공권 조회

<img src="https://user-images.githubusercontent.com/95206325/152370176-b639bf7f-a153-4fa8-beba-471f0ccccfb1.jpg" width="600">

* 배너 리스트 수정

<img src="https://user-images.githubusercontent.com/95206325/152370180-4e1570e8-1e23-49c4-b703-a1f1ebe7bf19.png" width="600">

* 배너 리스트 수정

<img src="https://user-images.githubusercontent.com/95206325/152370195-df973c83-b85c-44aa-865c-469795658bb5.png" width="500" height="600">

* 배너 리스트 수정

<img src="https://user-images.githubusercontent.com/95206325/152370218-2c5c4c6c-f2f6-46df-a7a4-651c9d741ae1.png" width="500" height="600">

## 느낀 점
기획 단계에서 사용자 위주로 기획하다보니 이후 화면 설계 단계에서 관리자 영역에 대한 이해도가 각자 달라 어려움이 있었으며, 구현 단계에서 데이터를 추가적으로 조작하는 일이 있었다. 또한 사용보다는 기능 구현에 초점을 맞추다보니 많은 기능을 기획했고, 오히려 기능이 많아 집중도가 떨어지는 결과를 낳게 되었다.

이후에 있을 프로젝트에서는 사용자 관점의 기획이 아닌 서비스 기획자의 관점에서 기획이 필요하다는 걸 깨달았고, 서버 관리와 데이터 관리를 보다 안정적으로 할 예정이다.
