package cn.test.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Set;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("/sayhello")
    public String sayHello(User user, Model model){
        System.out.println("hello");
        System.out.println(user);
        model.addAttribute("meimei",user);
        return "success";
    }
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String testUpload(HttpServletRequest request, @RequestParam("upload1") MultipartFile[] upload){
        String path=request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(path);
        File file=new File(path);
        if( !file.exists()){
            file.mkdirs();
        }
        for (MultipartFile multipartFile : upload) {
            String filename=multipartFile.getOriginalFilename();
            String uuid= UUID.randomUUID().toString().replace("-","");
            filename=uuid+"-"+filename;
            try {
                multipartFile.transferTo(new File(path,filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "success";
    }
    @RequestMapping(value = "/filedownload",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) throws IOException {
        String path=request.getSession().getServletContext().getRealPath("/upload/");
        File file=new File(path);
        if( !file.exists()){
            file.mkdirs();
        }
        File file1=new File(file,filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");

        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // MediaType:互联网媒介类型 contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file1), headers, HttpStatus.CREATED);

    }
//    @ModelAttribute
//    public User set(String name){
//        User user=new User();
//        user.setName("zhansan");
//        user.setPassword("1111");
//        user.setAge(11);
//        System.out.println("ModelAttribute1先执行了");
//        System.out.println(user);
//        return user;
//    }
//    @RequestMapping("/sayhello1")
//    public String sayHello1(@ModelAttribute("user") User user){
//        System.out.println("hello1");
//        System.out.println(user);
//        return "success";
//    }
//    @ModelAttribute
//    public User set1(String name, Map<String,User> map){
//        User user=new User();
//        user.setName("zhansan1");
//        user.setPassword("2222");
//        user.setAge(22);
//        System.out.println("ModelAttribute2先执行了");
//        map.put("user",user);
//        for(String s:map.keySet()) {
//            System.out.println(map.get(s));
//        }
//        return user;
//    }
}
