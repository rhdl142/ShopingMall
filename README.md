# SIST ShopingMall
<b>기간 : 2018.11.06 ~ 2018.11.12</b><br>
<b>환경 : 콘솔 기반 Eclipse</b><br>
<b>주제 : 쇼핑몰</b><br>
<b>개발 : Eclipse Photon, Oracle</b><br>
<b>사용 언어 : JAVA(JDK 1.8), Oracle SQL(11g Express)</b><br>
<b>사용 기술 : JDBC + MVC모델</b><br>

# 프로젝트 상세내용
## 주제
<pre>
* GitHub를 이용한 SIST 쇼핑몰 운영 프로그램<br>
</pre>

## 목적
<pre>
* 방대한 데이터를 편리한 UI를 통해 유저에게 맞는 서비스를 제공<br>
* 객관적인 데이터를 통해 회원에게 필요한 맞춤 정보 서비스를 제공<br>
</pre>

## 사용대상
* 회원고객
<pre>
* 쇼핑하기<br>
* 내 정보 보기<br>
* 주문/배송내역 보기<br>
* 이벤트 내역보기<br>
* 고객센터<br>
</pre>
* 관리자
<pre>
* 회원 관리<br>
* 상품 관리<br>
* 주문/배송 관리<br>
* 고객 센터 관리<br>
* 매출 관리<br>
</pre>

## Exerd 테이블 명세
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%84%A4%EA%B3%84%EB%8F%84.PNG)

## 구동 화면
* 회원 메인화면<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/1.%20%ED%9A%8C%EC%9B%90%EB%A9%94%EC%9D%B8.PNG)
* 회원 쇼핑하기<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/2.%20%ED%9A%8C%EC%9B%90%20%EC%87%BC%ED%95%91%ED%95%98%EA%B8%B0.PNG)
* 상품 보기<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/3.%20%EC%83%81%ED%92%88%20%EB%B3%B4%EA%B8%B0.PNG)
* 상품 검색<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/4.%20%EC%83%81%ED%92%88%EA%B2%80%EC%83%89.PNG)
* 회원 정보조회<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/5.%20%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4%20%EC%A1%B0%ED%9A%8C.PNG)

 ## Git 충돌 해결 과정
 * 충돌 장면<br><br>
![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/1.%20%EC%B6%A9%EB%8F%8C%EC%9E%A5%EB%A9%B4!!!.png)
> <<<<<<HEAD ~ >>>>> refs/remotes/origin/admin라는 키워드로 충돌이 발생한 상황을 나타내고 있다.  뒤의 키워드는 admin Branch에서 발생했다는 뜻으로 해석하면 좋을 것 같다.

 * merge 툴을 활용한 충돌 제어<br><br>
 ![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/2.%20%EB%A8%B8%EC%A7%80%ED%88%B4%20%ED%99%9C%EC%9A%A9%ED%95%B4%EC%84%9C%20%EC%B6%A9%EB%8F%8C%EC%A0%9C%EC%96%B4!!.png)
 > Conflict가 발생한 클래스 우 클릭 -> Team -> Merge Tool을 눌러 현재 클래스의 master의 최신 commit 버전과 merge 할 Branch의 최신 commit 버전을 보여주고 있다. 가운데의 선으로 코드가 이어져 있으며 선 가운데에 있는 까만 점을 클릭하여 코드를 수정하였고, 충돌을 모두 제어할 수 있었다.
 
 * 히스토리<br><br>
 ![Alt text](https://github.com/rhdl142/ShopingMall/blob/master/imgfile/3.%20%ED%9E%88%EC%8A%A4%ED%86%A0%EB%A6%AC.png)
 > 이번 프로젝트의 History이다.
 
 # Git/GitHub를 활용하여 느낀점
 * 우성환
 > 익숙하다 못해 몸에 배긴 콘솔환경 + Oracle DB를 활용한 프로젝트에서 Git과 GitHub라는 저장소를 이용했다는 점 하나만으로도 많이 어색했던 느낌이 있었고, 능숙하지는 못하지만 Git이 어떤 역할을 하는지, GitHub라는 원격 저장소가 어떤 역할을 하는지, Branch, Master의 존재 의미, commit에서의 의미단위 등 새로운 것을 접했던 기회였던 것 같습니다. 개발자라는 직업 특성상 항상 신기술에 대해 열린 마음을 지니고 있어야 한다고 생각하며 Eclipse와 Git/GitHub의 활용 어려움과 같은 이유로 때론 위험에 직면하기도 하였지만 익숙한 환경에 새로운 기술을 더했다는 만족감이 아주 만족스러운 프로젝트였습니다.
 * 임광민
 > Git을 혼자 공부하고 혼자 해보다가 처음으로 학원 친구와 협업을 통해서 활용해보았다. 혼자하는것과 협업을 하여 하는 것은 많은 차이가 있었고, 두명다 능숙하지 못하였기 떄문에 막힌 부분도 많았다. 주말간 개인 Branch에 코딩을 하여 커밋하고 Merge를 하자고 했다. 주말간 진행했던 내용을 commit 하는 과정에 했던 내용이 사라졌다. 알림창이 떳는데 잘 확인하지 않고 버튼을 눌렀고 맨 처음 내용으로 돌아와 있었다. 그 과정에서 브랜치, git History, git Log, git reset 등 다양한 명령어를 검색해보고 활용해 볼 수 있는 좋은 기회였다. 아직 미숙하지만 내 것으로 만든다면 많은 이점이 있기 떄문에 더욱더 활용해보고 싶다.
