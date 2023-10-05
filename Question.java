package exercise1;

import java.util.List;

public class Question {
    private String header;
    private List<String> options;
    private String answer;

    public Question() {
    }

    public String getHeader() {
        return header;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String showOptions(){
        String result= "";

        for (String option : options){
            result += option + "\n" ;

        }
        return result;
    }
}
