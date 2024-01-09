package com.kh.app.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

public class TestMain {

   public static void main(String[] args) {

      GalleryDao dao = new GalleryDao();
      SqlSessionTemplate sst = new SqlSessionTemplate(null);
      GalleryService service = new GalleryService(dao, sst);

      //작성하기
      test01(service);
      //목록조회
      test02(service);
   
   }

   private static void test02(GalleryService service) {
      List<GalleryVo>gvoList = service.list();
      
      if(gvoList.size() == 1) {
         System.out.println("[테스트:목록조회] 성공");
      }else {
         System.out.println("[테스트:목록조회] 실패");
      }
   }

   public static void test01(GalleryService service) {
      GalleryVo gvo = new GalleryVo();
      gvo.setTitle("제목01");
      gvo.setFullPath("D:/dev/zzz.png");
      gvo.setWriterNo("1");
      int result = service.write(gvo);
   
      if(result == 1) {
         System.out.println("[테스트:작성하기] 성공");
      }else {
         System.out.println("[테스트:작성하기] 실패");
      }
   }
   
   
}