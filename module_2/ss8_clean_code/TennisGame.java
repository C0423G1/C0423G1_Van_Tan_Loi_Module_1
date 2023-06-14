package ss8_clean_code;

public class TennisGame {
    public static final char ZEROPOINT = 0;
    public static final char ONEPOINT = 1;
    public static final char TWOPOINT = 2;
    public static final char THREEPOINT = 3;


    public static String getScore(String playerNameOne, String playerNameTwo, int scoreOne, int scoreTwo) {
        String score = "";
        int tempScore = 0;
        if (scoreOne == scoreTwo) {
            switch (scoreOne) {
                case ZEROPOINT:
                    score = "Love-All";
                    break;
                case ONEPOINT:
                    score = "Fifteen-All";
                    break;
                case TWOPOINT:
                    score = "Thirty-All";
                    break;
                case THREEPOINT:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            int minusResult = scoreOne - scoreTwo;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scoreOne;
                else {
                    score += "-";
                    tempScore = scoreTwo;
                }
                switch (tempScore) {
                    case ZEROPOINT:
                        score += "Love";
                        break;
                    case ONEPOINT:
                        score += "Fifteen";
                        break;
                    case TWOPOINT:
                        score += "Thirty";
                        break;
                    case THREEPOINT:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}