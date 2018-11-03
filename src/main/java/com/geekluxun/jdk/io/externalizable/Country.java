package com.geekluxun.jdk.io.externalizable;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author: luxun
 * @Create: 2018-11-03 15:32
 * @Description:
 * @Other:
 */
@Data
public class Country implements Externalizable {

    private String name;
    private String capital;
    private int code;


    /**
     * 自定义序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(capital);
        out.writeInt(code);
    }

    /**
     * 自定义反序列化
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.capital = in.readUTF();
        this.code = in.readInt();
    }
}
