package hu.sandysoft.beosztas.repository;

import hu.sandysoft.beosztas.dto.Performance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface PerformanceRepository {

    @Insert("INSERT INTO performances (name, preparation_time, table_needed, move_needed, head_needed) "
            + "VALUES (#{name}, #{preparation_time}, #{table_needed}, #{move_needed}, #{head_needed})")
    public int addPerformance(Performance performance);

    @Select("SELECT * FROM performances")
    public List<Performance> getPerformances();

    @Delete("DELETE FROM performances WHERE name = #{name}")
    public int deletePerformanceByName(String name);

}
