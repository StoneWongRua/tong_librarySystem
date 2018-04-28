package com.tong.librarySystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.tong.librarySystem.entity.Admin;
import com.tong.librarySystem.entity.Book;
import com.tong.librarySystem.entity.Borrow;
import com.tong.librarySystem.entity.Reader;
import com.tong.librarySystem.util.DbUtil;

public class BorAndRetDao {
	static DbUtil conn = new DbUtil();
    public int insert() {
    	String sql = "INSERT INTO tb_borrow (bookid) vlaues(1) ";
        int ret = conn.executeUpdate(sql);
        return ret;
    }
    /*
     * ͼ�����
     */
    @SuppressWarnings("unused")
	public static int insertBorrow(Reader reader, Book book){
        //��ȡϵͳ����
        Date dateU=new Date();
        java.sql.Date date=new java.sql.Date(dateU.getTime());
       String sql="select borrow_date from  borrow where ISBN = '"+book.getISBN()+" ";
        ResultSet rs = conn.executeQuery(sql);
        int days = 0;
        try {
            if (rs.next()) {
                days = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        //����黹ʱ��
          String date_str=String.valueOf(date);
          String dd = date_str.substring(8,10);
          String DD = date_str.substring(0,8)+String.valueOf(Integer.parseInt(dd) + days);
          java.sql.Date backTime= java.sql.Date.valueOf(DD);

          String sql2 ="Insert into borrow (ISBN, book_name, reader_no, reader_tel, borrow_date, return_date, operator, if_back) values("+book.getISBN()+","+book.getBook_name()+",'"+reader.getReader_no()+","+reader.getReaer_tel() +", '" +Borrow.getBorrow_date() +"', " + ",' " + Borrow.getReturn_date() + "')";
           int status = conn.executeUpdate(sql2);
          conn.close();
          return status;
}
      //ͼ��̽�
    /*  public int renew(int ISBN){
          String sql0 = "SELECT ISBN FROM borrow WHERE ISBN= ' "+ ISBN + "'";
          ResultSet rs1 = conn.executeQuery(sql0);
          int flag = 0;
          try {
            if (rs1.next()) {
                //��ȡϵͳ����
                Date dateU = new Date();
                java.sql.Date date = new java.sql.Date(dateU.getTime());
                String sql1 = "select t.days from tb_bookinfo b left join tb_booktype t on b.typeid=t.id where b.id=" +
                              rs1.getInt(1) + "";
                ResultSet rs = conn.executeQuery(sql1);
                int days = 0;
                try {
                    if (rs.next()) {
                        days = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                }
                //����黹ʱ��
                String date_str = String.valueOf(date);
                String dd = date_str.substring(8, 10);
                String DD = date_str.substring(0, 8) +
                            String.valueOf(Integer.parseInt(dd) + days);
                java.sql.Date backTime = java.sql.Date.valueOf(DD);

                String sql = "UPDATE tb_borrow SET backtime='" + backTime +
                             "' where id=" + id + "";
                flag = conn.executeUpdate(sql);
            }
          } catch (Exception ex1) {}
          conn.close();
          return flag;
      }*/
      //*************************************ͼ��黹*********************************
      public int back(Reader reader, Book book, String operator, int ISBN){
          String sql0="SELECT reader_no FROM borrow WHERE reader_no="+ reader.getReader_no() +"";
          ResultSet rs1 = conn.executeQuery(sql0);
          int status = 0;
        try {
            if (rs1.next()) {
                //��ȡϵͳ����
                Date dateU = new Date();
                java.sql.Date date = new java.sql.Date(dateU.getTime());
                int readerid=rs1.getInt(1);
                int bookid=rs1.getInt(2);
                String sql1="Insert into borrow (ISBN, book_name, reader_no, reader_tel, borrow_date, admin_no, return_date, operator, if_back) values("+book.getISBN()+","+book.getBook_name()+",'"+reader.getReader_no()+","+reader.getReaer_tel() +", '" +Borrow.getReturn_date() +"', " + Admin.getAdmin_no() +",' " + Borrow.getReturn_date() + "')";
                int ret=conn.executeUpdate(sql1);
                if(ret==1){
                    String sql2 = "UPDATE borrow SET if_back=1 where ISBN = " + ISBN;
                    status = conn.executeUpdate(sql2);
                }else{
                    status = 0;
                }
            }
        } catch (Exception ex1) {
        }
          conn.close();
          return status;
      }
 /*   //*****************************��ѯͼ�������Ϣ************************
      public Collection borrowinfo(String str){
      String sql="select borr.*,book.bookname,book.price,pub.pubname,bs.name bookcasename,r.barcode from (select * from tb_borrow where ifback=0) as borr left join tb_bookinfo book on borr.bookid=book.id join tb_publishing pub on book.isbn=pub.isbn join tb_bookcase bs on book.bookcase=bs.id join tb_reader r on borr.readerid=r.id where r.barcode='"+str+"'";
      ResultSet rs=conn.executeQuery(sql);
      Collection coll=new ArrayList();
      BorrowForm form=null;
      try {
          while (rs.next()) {
              form = new BorrowForm();
              form.setId(Integer.valueOf(rs.getInt(1)));
              form.setBorrowTime(rs.getString(4));
              form.setBackTime(rs.getString(5));
              form.setBookName(rs.getString(8));
              form.setPrice(Float.valueOf(rs.getFloat(9)));
              form.setPubName(rs.getString(10));
              form.setBookcaseName(rs.getString(11));
              coll.add(form);
          }
      } catch (SQLException ex) {
          System.out.println("������Ϣ��"+ex.getMessage());
      }
      conn.close();
      return coll;
      }
      //*************************��������******************************************
    public Collection bremind(){
    Date dateU = new Date();
    java.sql.Date date = new java.sql.Date(dateU.getTime());
    String sql="select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid where borr.backTime <='"+date+"'";
    ResultSet rs=conn.executeQuery(sql);
    System.out.println("��ʱ���ѵ�SQL��"+sql);
    Collection coll=new ArrayList();
    BorrowForm form=null;
    try {
        while (rs.next()) {
            form = new BorrowForm();
            form.setBorrowTime(rs.getString(1));
            form.setBackTime(rs.getString(2));
            form.setBookBarcode(rs.getString(3));
            form.setBookName(rs.getString(4));
            form.setReaderName(rs.getString(5));
            form.setReaderBarcode(rs.getString(6));
            coll.add(form);
            System.out.println("ͼ�������룺"+rs.getString(3));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    conn.close();
    return coll;
}
//*************************ͼ����Ĳ�ѯ******************************************
public Collection borrowQuery(String strif){
    String sql="";
    if(strif!="all" && strif!=null && strif!=""){
        sql="select * from (select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode,borr.ifback from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid) as borr where borr."+strif+"";
    }else{
        sql="select * from (select borr.borrowTime,borr.backTime,book.barcode,book.bookname,r.name readername,r.barcode readerbarcode,borr.ifback from tb_borrow borr join tb_bookinfo book on book.id=borr.bookid join tb_reader r on r.id=borr.readerid) as borr";
}
ResultSet rs=conn.executeQuery(sql);
System.out.println("ͼ����Ĳ�ѯ��SQL��"+sql);
Collection coll=new ArrayList();
BorrowForm form=null;
try {
    while (rs.next()) {
        form = new BorrowForm();
        form.setBorrowTime(rs.getString(1));
        form.setBackTime(rs.getString(2));
        form.setBookBarcode(rs.getString(3));
        form.setBookName(rs.getString(4));
        form.setReaderName(rs.getString(5));
        form.setReaderBarcode(rs.getString(6));
        form.setIfBack(rs.getInt(7));
        coll.add(form);
    }
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
conn.close();
return coll;
    }
      //*************************ͼ���������******************************************
    public Collection bookBorrowSort() {
       String sql = "select * from (SELECT bookid,count(bookid) as degree FROM tb_borrow group by bookid) as borr join (select b.*,c.name as bookcaseName,p.pubname,t.typename from tb_bookinfo b left join tb_bookcase c on b.bookcase=c.id join tb_publishing p on b.ISBN=p.ISBN join tb_booktype t on b.typeid=t.id where b.del=0) as book on borr.bookid=book.id order by borr.degree desc limit 10 ";
        System.out.println("ͼ��������У�"+sql);
        Collection coll = new ArrayList();
        BorrowForm form = null;
        ResultSet rs = conn.executeQuery(sql);


        try {
            while (rs.next()) {
                form = new BorrowForm();
                form.setBookId(rs.getInt(1));
                form.setDegree(rs.getInt(2));
                form.setBookBarcode(rs.getString(3));
                form.setBookName(rs.getString(4));
                form.setAuthor(rs.getString(6));
                form.setPrice(Float.valueOf(rs.getString(9)));
          
                form.setBookcaseName(rs.getString(16));
                form.setPubName(rs.getString(17));
                form.setBookType(rs.getString(18));
                coll.add(form);
                System.out.print("RS��"+rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        conn.close();
        return coll;
    }*/
}