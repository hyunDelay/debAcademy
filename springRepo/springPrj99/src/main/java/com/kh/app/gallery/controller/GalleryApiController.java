package com.kh.app.gallery.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/gallery")
@RequiredArgsConstructor
public class GalleryApiController {
   
   private final GalleryService service;
   
   //작성하기
   @PostMapping
   public Map<String, String> write(GalleryVo vo, MultipartFile f) throws Exception {
	  
	   System.out.println("vo : " + vo);
	   System.out.println("f : " + f.getOriginalFilename());
	   
	   String fullPath = saveFile(f);
	   vo.setFullPath(fullPath);
	   System.out.println("vo : " + vo);
	   
       int result = service.write(vo);
      
       Map<String, String> map = new HashMap<>();
       map.put("msg", "good");
       if(result != 1) {
    	  map.put("msg", "bad");
       }
      
      return map;
   }
   
   /**
    * 파일을 서버에 저장하고, 파일 전체 경로를 리턴함
 * @param path 
    * 
    * @param 파일객체
    * @Param 파일경로
    * @return 실제 파일저장경로 (파일경로 + 파일명)
	* @throws Exception
    * */
   private String saveFile(MultipartFile f) throws Exception {
	   
	   String path = "D:\\debAcademy\\springRepo\\springPrj99\\src\\main\\webapp\\resources\\upload\\gallery\\img\\";
	   String originName = f.getOriginalFilename();
	   
	   // 원래는 path + 랜덤이름 + 확장자로 해야함
	   File target = new File(path + originName);
	   
	   // 파일 바이트 코드 읽어서 타겟에 저장
	   f.transferTo(target);
	   
	   return path + originName;
   }

   //목록조회
   @GetMapping("list")
   public Map<String, Object> list() {
      List<GalleryVo> voList = service.list();
      Map<String, Object> map = new HashMap<>();
      map.put("msg", "good");
      map.put("voList", voList);
      
      return map;
   }
   
   //단일조회
   @GetMapping
   public void detail() {
      
   }
   //수정하기
   public void edit() {
      
   }
   //삭제하기
   public void delete() {
      
   }
}