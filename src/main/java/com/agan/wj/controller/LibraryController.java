package com.agan.wj.controller;

import com.agan.wj.pojo.Book;
import com.agan.wj.service.BooksService;
import com.agan.wj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class LibraryController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    public List<Book> list() throws Exception{
        return booksService.list();
    }

//    @GetMapping("/pageBooks")
//    public List<Book> pageList() throws Exception{
//        return bookService.pageList();
//    }

    @PostMapping("/books")
    public void addOrUpdate(@RequestBody Book book) throws Exception{
       booksService.addOrUpdate(book);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Book book){
        booksService.deleteById(book.getId());
    }

//    @GetMapping("/categories/{cid}/books")
//    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
//        if (0 != cid){
//            return booksService.listByCategory(cid);
//        }
//        return list();
//    }

    @GetMapping("/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)){
            return booksService.list();
        }
        return booksService.search(keywords);
    }

    @PostMapping("/covers")
    public String coverUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
