import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiForm extends JFrame {
    JLabel lnim, lnama, lmatkul1, lnilai1, lmatkul2, lnilai2;
    JTextField txnim, txnama, txmatkul1, txnilai1, txmatkul2, txnilai2;
    JButton done, clear;
    
    public void form(){
        setTitle("Hitung Nilai");
         
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");
        lmatkul1 = new JLabel("Mata Kuliah 1");
        lnilai1 = new JLabel("Nilai 1");
        lmatkul2 = new JLabel("Mata Kuliah 2");
        lnilai2 = new JLabel("Nilai 2");
         
        txnim = new JTextField("");
        txnama = new JTextField("");
        txmatkul1 = new JTextField("");
        txnilai1 = new JTextField("");
        txmatkul2 = new JTextField("");
        txnilai2 = new JTextField("");
        
        done = new JButton("Convert");
        clear = new JButton("Clear");
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmatkul1);
        add(lnilai1);
        add(lmatkul2);
        add(lnilai2);
        add(txnim);
        add(txnama);
        add(txmatkul1);
        add(txnilai1);
        add(txmatkul2);
        add(txnilai2);
        add(done);
        add(clear);
        
        lnim.setBounds(30, 20, 40, 25);
        txnim.setBounds(130, 20, 230, 25);
        lnama.setBounds(30, 55, 40, 25);
        txnama.setBounds(130,55, 230, 25);
        lmatkul1.setBounds(30, 90, 100, 25);
        txmatkul1.setBounds(130, 90, 230, 25);
        lnilai1.setBounds(30, 125, 100, 25);
        txnilai1.setBounds(130, 125, 230, 25);
        lmatkul2.setBounds(30, 160, 100, 25);
        txmatkul2.setBounds(130, 160, 230, 25);
        lnilai2.setBounds(30, 195, 100, 25);
        txnilai2.setBounds(130, 195, 230, 25);
        done.setBounds(109, 240, 120, 25);
        clear.setBounds(239, 240, 120, 25);
        
        setSize(405,330); //luas tampilan
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Melakukan convert
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try{
                    Convert calculate = new Convert();
                    
                    String nim, nama, matkul1, matkul2, grade;
                    float nilai1, nilai2, rata;
                    nim =  txnim.getText();
                    nama = txnama.getText();
                    matkul1 = txmatkul1.getText();
                    nilai1 =  Float.parseFloat(txnilai1.getText());
                    matkul2 = txmatkul2.getText();
                    nilai2 =  Float.parseFloat(txnilai2.getText());
                    //Melakukan test nilai, melempar nilai ke testing
                    testing(nim, nama, matkul1, nilai1, matkul2, nilai2);
                    //Melakukan perhitung rata - rata, melempar nilai ke Convert/hasil
                    rata = calculate.hasil(nilai1, nilai2);
                
                    System.out.println("NIM\t\t: "+nim);
                    System.out.println("Nama\t\t: "+nama);
                    System.out.println("Mata Kuliah 1\t: "+matkul1);
                    System.out.println("Mata Kuliah 2\t: "+matkul2);
                    System.out.println("Rata - rata\t: "+rata);
                    //Mengambil data nilai huruf dari Convert/hitung
                    System.out.println("Nilai  Huruf\t: "+calculate.hitung(rata));
                
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane,"Tipe Data Salah");
                }catch(ErrorException ext) {
                    JOptionPane.showMessageDialog(rootPane,ext);
                } 
            }
        });
         
        //Membersihkan(mereset) nilai form pada textbox
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ep) {
                txnim.setText("");
                txnama.setText("");
                txmatkul1.setText("");
                txmatkul2.setText("");
                txnilai1.setText("");
                txnilai2.setText("");
            }
        });
    }
    
    //Melakukan test nilai
    public void testing(String nim, String nama, String matkul1, float nilai1, String matkul2, float nilai2) throws ErrorException{
        //Tes data masukkan, seluruh data input harus terisi
        if (!(nim.length() > 0 && nama.length() > 0 && matkul1.length() > 0 && (Float.toString(nilai1)).length() > 0 && matkul2.length() > 0 && (Float.toString(nilai2)).length() > 0)){
            throw new ErrorException("Input masih kosong");
        }
        //Tes input nilai sesuai batasan nilai angka
        else if (!(nilai1 >= 0 && nilai1 <= 100 && nilai2 >= 0 && nilai2 <= 100)) {
            throw new ErrorException("Masukan data nilai antara ( 1 - 100 )");
        }
    }
}
