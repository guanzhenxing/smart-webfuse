package net.webfuse.common.exception.exhandler;

import org.springframework.core.convert.converter.Converter;

/**
 * RestfulError转换器，将RestfulError对象转换成其他对象
 * Created by guanzhenxing on 2018/1/5.
 */
public interface RestfulErrorConverter<T> extends Converter<RestfulError, T> {

    @Override
    T convert(RestfulError restfulError);

}
