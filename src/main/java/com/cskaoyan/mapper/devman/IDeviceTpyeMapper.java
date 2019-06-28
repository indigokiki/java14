package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.DeviceType;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface IDeviceTpyeMapper {
    @Select("select * from device_type")
 @Results(
         {
                 @Result(id=true,property = "deviceTypeId",column = "device_type_id"),
                 @Result(property = "deviceTypeName",column = "device_type_name"),
                 @Result(property = "deviceTypeModel",column = "device_type_model"),
                 @Result(property = "deviceTypeSpec",column = "device_type_spec"),
                 @Result(property = "deviceTypeSupplier",column = "device_type_supplier"),
                 @Result(property = "deviceTypeProducer",column = "device_type_producer"),
                 @Result(property = "deviceTypeQuantity",column = "device_type_quantity"),
                 @Result(property = "deviceTypeWarranty",column = "device_type_warranty")
         }
 )
    public List<DeviceType> findAll();

    @Select("select device_type_id from device_type where device_type_name like #{name}")
    List<String> findIdByName(String name);

    @Select("select * from device_type where device_type_id=#{id}")
    @Results(
            {
                    @Result(id=true,property = "deviceTypeId",column = "device_type_id"),
                    @Result(property = "deviceTypeName",column = "device_type_name"),
                    @Result(property = "deviceTypeModel",column = "device_type_model"),
                    @Result(property = "deviceTypeSpec",column = "device_type_spec"),
                    @Result(property = "deviceTypeSupplier",column = "device_type_supplier"),
                    @Result(property = "deviceTypeProducer",column = "device_type_producer"),
                    @Result(property = "deviceTypeQuantity",column = "device_type_quantity"),
                    @Result(property = "deviceTypeWarranty",column = "device_type_warranty")
            }
    )
    DeviceType findByTypeId(String id);

    @Update({
            "update device_type",
            "set device_type_name = #{deviceTypeName,jdbcType=VARCHAR},",
            "device_type_model = #{deviceTypeModel,jdbcType=VARCHAR},",
            "device_type_spec = #{deviceTypeSpec,jdbcType=VARCHAR},",
            "device_type_supplier = #{deviceTypeSupplier,jdbcType=VARCHAR},",
            "device_type_producer = #{deviceTypeProducer,jdbcType=VARCHAR},",
            "device_type_quantity = #{deviceTypeQuantity,jdbcType=INTEGER},",
            "device_type_warranty = #{deviceTypeWarranty,jdbcType=TIMESTAMP}",
            "where device_type_id = #{deviceTypeId,jdbcType=VARCHAR}"
    })

    void update(DeviceType deviceType);

    @Insert({
            "insert into device_type (device_type_id, device_type_name, ",
            "device_type_model, device_type_spec, ",
            "device_type_supplier, device_type_producer, ",
            "device_type_quantity, device_type_warranty)",
            "values (#{deviceTypeId,jdbcType=VARCHAR}, #{deviceTypeName,jdbcType=VARCHAR}, ",
            "#{deviceTypeModel,jdbcType=VARCHAR}, #{deviceTypeSpec,jdbcType=VARCHAR}, ",
            "#{deviceTypeSupplier,jdbcType=VARCHAR}, #{deviceTypeProducer,jdbcType=VARCHAR}, ",
            "#{deviceTypeQuantity,jdbcType=INTEGER}, #{deviceTypeWarranty,jdbcType=TIMESTAMP})"
    })

    void insert(DeviceType deviceType);

    @Delete({
            "delete from device_type",
            "where device_type_id = #{deviceTypeId,jdbcType=VARCHAR}"
    })
    void delete(String id);
}
