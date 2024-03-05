package common;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();
    private UtilServiceImpl(){}
    public static UtilService getInstance() {
        return instance;
    }

    @Override
    public int createRandomInteger(int start, int gapOfStartAndEnd) {
        return start + (int)(Math.random() * gapOfStartAndEnd);
    }

    @Override



    public double createRandomDouble(int start, int gapOfStartAndEnd) {
        return Math.floor(((start + Math.random() * gapOfStartAndEnd) * 10) / 10);
    }

    @Override
    public String createRandomJob() {
        String[] names = {"경찰", "소방관", "세일즈맨", "교수", "회계사",
                "공무원", "의사"};
        return names[createRandomInteger(0,6)];
    }

    @Override
    public String createRandomName() {
        String[] name = {"이정재", "마동석", "송강호", "윤여정", "황정민", "정우성",
                "이병헌", "현 빈", "유해진", "손석구", "전도연", "손예진", "하지원", "김하늘",
                "송중기", "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜수"};

        return name[createRandomInteger(0, 20)];
    }

    @Override
    public String createRandomTitle() {
        String[] titles = {"대한민국의 주권", "군사재판을 관할", "모든 국민", "국가는 근로의 의무",
                "국가는 청원", "헌법재판소 재판관", "외국인은 국제법과 조약", "대법원장과 대법관",
                "대통령의 임기", "국회는 정부의 동의", "국무위원은 국무총리", "법관이 중대한 심신상의 장해",
                "감사위원은 원장"
        };

        return titles[createRandomInteger(0, 13)];
    }

    @Override
    public String createRandomContent() {
        String[] content = {"대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.",
                "군사재판을 관할하기 위하여 특별법원으로서 군사법원을 둘 수 있다.",
                "모든 국민은 근로의 의무를 진다.",
                "국가는 근로의 의무의 내용과 조건을 민주주의원칙에 따라 법률로 정한다.",
                "국가는 청원에 대하여 심사할 의무를 진다.",
                "헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다.",
                "외국인은 국제법과 조약이 정하는 바에 의하여 그 지위가 보장된다.",
                "대법원장과 대법관이 아닌 법관은 대법관회의의 동의를 얻어 대법원장이 임명한다.",
                "대통령의 임기가 만료되는 때에는 임기만료 70일 내지 40일전에 후임자를 선거한다.",
                "국회는 정부의 동의없이 정부가 제출한 지출예산 각항의 금액을 증가하거나 새 비목을 설치할 수 없다.",
                "국무위원은 국무총리의 제청으로 대통령이 임명한다.",
                "법관이 중대한 심신상의 장해로 직무를 수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.",
                "감사위원은 원장의 제청으로 대통령이 임명하고, 그 임기는 4년으로 하며, 1차에 한하여 중임할 수 있다."
        };

        return content[createRandomInteger(0, 13)];
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글", "엔디비아", "메타", "삼성", "LG", "애플"};
        return companies[createRandomInteger(0, 6)];
    }

    @Override
    public String createRandomUserName() {
        String username = "";
        for(; username.length() < 5; username += String.valueOf((char)('a' + this.createRandomInteger(0, 26))));
        // a가 아스키코드 97 z가 아스키코드 122니까 26까지의 경우에서 하는 것.

        return username;
    }
}
