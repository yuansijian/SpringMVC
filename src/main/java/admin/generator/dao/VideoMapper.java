package admin.generator.dao;

import admin.generator.entity.Video;
import admin.generator.entity.VideoWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(VideoWithBLOBs record);

    int insertSelective(VideoWithBLOBs record);

    VideoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(VideoWithBLOBs record);

    int updateByPrimaryKey(Video record);

    List<VideoWithBLOBs> queryAll();

    List<VideoWithBLOBs> fuzzyQuery(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("vname") String vname);
}