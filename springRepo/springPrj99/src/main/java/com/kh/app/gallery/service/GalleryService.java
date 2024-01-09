package com.kh.app.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.vo.GalleryVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryService {

   private final GalleryDao dao;
   private final SqlSessionTemplate sst;
   
   //작성하기
   public int write(GalleryVo vo) {
	   
	   String str = vo.getFullPath().replace("D:\\debAcademy\\springRepo\\springPrj99\\src\\main\\webapp", "http://localhost:8888/app");
	   vo.setFullPath(str);
	   
	   if(vo.getTitle().length()<1) {
		   throw new IllegalStateException();
	   }
	   return dao.write(sst, vo);
	   
   }
   
   //목록조회
   public List<GalleryVo> list(){
      return dao.list(sst);
   }
   
   //단일조회 (+조회수증가)
   public GalleryVo detail(String no) {
      int result = dao.increaseHit(sst, no);
      if(result != 1) {
         throw new IllegalStateException();
      }
      return dao.detail(sst, no);
   }
   
   //수정하기
   public int edit(GalleryVo vo) {
      if(vo==null) {
         throw new IllegalStateException("vo가 없음...");
      }
      if(vo.getTitle().length()<1 || vo.getTitle() != null) {
         throw new IllegalStateException("제목이 너무 짧음");
      }
      return dao.edit(sst, vo);
   }
   //삭제하기
}