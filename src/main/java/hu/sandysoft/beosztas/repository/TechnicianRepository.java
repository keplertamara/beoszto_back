package hu.sandysoft.beosztas.repository;

import hu.sandysoft.beosztas.dto.Technician;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TechnicianRepository {

    @Insert("INSERT INTO technicians (name, performance, `table`, `move`, head) "
            + "VALUES (#{name}, #{performance}, #{table}, #{move}, #{head})")
    public int addTechnician(Technician technician);

    @Select("SELECT * FROM technicians")
    public List<Technician> getTechnicians();

    @Delete("DELETE FROM technicians WHERE name = #{name}")
    public int deleteTechnicianByName(String name);

    @Delete("DELETE FROM technicians WHERE performance = #{performance}")
    public int deleteTechnicianByPerformance(String performance);
}
