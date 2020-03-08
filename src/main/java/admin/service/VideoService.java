package admin.service;

import admin.generator.entity.Video;
import admin.generator.entity.VideoWithBLOBs;

import java.util.List;

public interface VideoService
{
    List<VideoWithBLOBs> queryAll();

    List<VideoWithBLOBs> fuzzyQuery(String startTime, String endTime, String vname);

    int insert(VideoWithBLOBs record);

    VideoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoWithBLOBs record);


}
