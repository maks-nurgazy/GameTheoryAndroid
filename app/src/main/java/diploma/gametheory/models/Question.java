package diploma.gametheory.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("timer")
    @Expose
    private Integer timer;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("optA")
    @Expose
    private String optA;
    @SerializedName("optB")
    @Expose
    private String optB;
    @SerializedName("optC")
    @Expose
    private String optC;
    @SerializedName("optD")
    @Expose
    private String optD;
    @SerializedName("answer")
    @Expose
    private Integer answer;
    public final static Parcelable.Creator<Question> CREATOR = new Creator<Question>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return (new Question[size]);
        }

    }
            ;

    protected Question(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.timer = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.difficulty = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.question = ((String) in.readValue((String.class.getClassLoader())));
        this.optA = ((String) in.readValue((String.class.getClassLoader())));
        this.optB = ((String) in.readValue((String.class.getClassLoader())));
        this.optC = ((String) in.readValue((String.class.getClassLoader())));
        this.optD = ((String) in.readValue((String.class.getClassLoader())));
        this.answer = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Question() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTimer() {
        return timer;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(timer);
        dest.writeValue(difficulty);
        dest.writeValue(type);
        dest.writeValue(question);
        dest.writeValue(optA);
        dest.writeValue(optB);
        dest.writeValue(optC);
        dest.writeValue(optD);
        dest.writeValue(answer);
    }

    public int describeContents() {
        return 0;
    }

}