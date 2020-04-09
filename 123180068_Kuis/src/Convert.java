
public class Convert {
    //Menghitung rata - rata
    public float hasil(float x, float y){
        float hasil_rata = (x+y)/2;
        return(hasil_rata);
    }
    
    //Mengkonversi nilai menjadi huruf
    public String hitung(float rata){
        if (rata >= 80 && rata <= 100) return "A";
        else if (rata >= 75 && rata < 80) return "B+";
        else if (rata >= 65 && rata < 75) return "B";
        else if (rata >= 60 && rata < 65) return "C+";
        else if (rata >= 50 && rata < 60) return "C";
        else if (rata >= 20 && rata < 50) return "D";
        else if (rata >= 0 && rata < 20) return "E";
        else return "Error";
    }
}
