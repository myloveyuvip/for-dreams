package com.yuliyao.designp.create;

import com.google.common.base.Strings;
import lombok.Getter;

/**
 * 构建器模式
 *
 * @author YuLiyao
 * @date 2020/7/21
 */
@Getter
public class ResourcePoolConfig {

    private final String name;

    private final int maxTotal;

    private final int maxIdle;

    private final int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;
    }

    public static Builder builder() {
        return new Builder();
    }



    public static class Builder{

        private String name;

        private int maxTotal;

        private int maxIdle;

        private int minIdle;

        private final int MAX_TOTAL = 8;
        private final int MAX_IDLE = 8;
        private final int MIN_IDLE = 8;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder maxIdle(int maxIdle){
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder minIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public ResourcePoolConfig build() {
            if (Strings.isNullOrEmpty(name)) {
                throw new IllegalArgumentException("name cannot be empty");
            }
            if (this.maxIdle <= 0) {
                this.maxIdle = this.MAX_IDLE;
            }
            if (this.minIdle < 0) {
                this.minIdle = this.MIN_IDLE;
            }
            if (this.maxTotal <= 0) {
                this.maxTotal = this.MAX_TOTAL;
            }
            //这里可以继续添加业务逻辑判断
            return new ResourcePoolConfig(this);
        }
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }
}
