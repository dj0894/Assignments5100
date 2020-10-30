package animalhospital;

import java.text.ParseException;

public interface Boardable {

    public void setBoardStart(int month, int day, int year) throws ParseException;
    public void setBoardEnd(int month, int day, int year) throws ParseException;
    public boolean boarding(int month, int day, int year) throws ParseException;
}
