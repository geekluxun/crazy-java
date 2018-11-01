package com.geekluxun.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Test;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-02 11:20
 * @Description:
 * @Other:
 */
public class ExeclUtilsTest {
    @Test
    public void readLocalFile() throws Exception {
        Workbook wookbook = ExeclUtils.readLocalFile("/xxd_voucher_template_czd.xlsx");
        Sheet firstSheet = wookbook.getSheetAt(0);
        firstSheet.getRow(9).getCell(17).setCellValue("-");
        Assert.assertTrue(true);
    }

}