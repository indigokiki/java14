package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.DeviceType;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
}
