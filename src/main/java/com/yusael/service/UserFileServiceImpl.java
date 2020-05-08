package com.yusael.service;

import com.yusael.dao.UserFileDAO;
import com.yusael.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private UserFileDAO userFileDAO;

    @Override
    public List<UserFile> findByUserId(Integer id) {
        userFileDAO.findByUserId(id);
        return userFileDAO.findByUserId(id);
    }

    @Override
    public void save(UserFile userFile) {
        // userFile.setIsImg(); // 是否是图片: 解决方案: 当类型中含有image时说明当前类型一定为图片类型
        String isImg = userFile.getType().startsWith("image") ? "是" : "否";
        userFile.setIsImg(isImg);
        userFile.setDowncounts(0);
        userFile.setUploadTime(new Date());
        userFileDAO.save(userFile);
    }
    @Override
    public UserFile findById(Integer id) {
        return userFileDAO.findById(id);
    }

    @Override
    public void update(UserFile userFile) {
        userFileDAO.update(userFile);
    }

    @Override
    public void delete(Integer id) {
        userFileDAO.delete(id);
    }

}
