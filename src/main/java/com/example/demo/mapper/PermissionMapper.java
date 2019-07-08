package com.example.demo.mapper;

import com.example.demo.model.Permission;
import com.example.demo.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @SelectProvider(type=PermissionSqlProvider.class, method="countByExample")
    long countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @DeleteProvider(type=PermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @Delete({
        "delete from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @Insert({
        "insert into permission (permission_name, permission_value)",
        "values (#{permissionName,jdbcType=VARCHAR}, #{permissionValue,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @InsertProvider(type=PermissionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @SelectProvider(type=PermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_value", property="permissionValue", jdbcType=JdbcType.VARCHAR)
    })
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, permission_name, permission_value",
        "from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_value", property="permissionValue", jdbcType=JdbcType.VARCHAR)
    })
    Permission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated
     */
    @Update({
        "update permission",
        "set permission_name = #{permissionName,jdbcType=VARCHAR},",
          "permission_value = #{permissionValue,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Permission record);
}