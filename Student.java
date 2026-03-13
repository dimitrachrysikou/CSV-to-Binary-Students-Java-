public class Student {
    private String am;
    private String onoma;
    private double bathmos;

    public Student(String am, String onoma, double bathmos){
        this.am = am;
        this.onoma = onoma;
        this.bathmos = bathmos;
    }


    public String getAm(){
        return am;
    }

    public void setAm(String am){
        this.am = am;
    }

    public String getOnoma(){
        return onoma;
    }

    public void setOnoma(String onoma){
        this.onoma = onoma;
    }

    public double getBathmos(){
        return bathmos;
    }

    public void setBathmos(double bathmos){
        this.bathmos = bathmos;
    }


    @Override
    public String toString(){
        return "AM: " + am + " Onoma: " + onoma + " Bathmos: " + bathmos;
    }
    


}
