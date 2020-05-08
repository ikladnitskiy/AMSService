package ru.kladnitskiy.AMSService.model.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.model.TypesOfWork;

import static ru.kladnitskiy.AMSService.model.dto.AmsDto.convertToAmsDto;

@RunWith(SpringRunner.class)
public class AmsDtoTest {

//    public final static TypesOfWork typeOfWork = new TypesOfWork(10000, true, true, false, true, true);
//    public final static Ams ams = new Ams(10000, "SP", 1278, "г. Санкт-Петербург, ул. Политехническая, д. 9", TypeAms.mast, 10.0, true, typeOfWork);
//    public final static AmsDto amsDto = new AmsDto(10000, "SP", 1278, "г. Санкт-Петербург, ул. Политехническая, д. 9", TypeAms.mast, 10.0, true, typeOfWork);
//
//    //переделать для сравнения по полям
//    @Test
//    public void testConvertToAmsDto() {
//        AmsDto result = convertToAmsDto(ams);
//        Assert.assertEquals(amsDto, result);
//    }

}