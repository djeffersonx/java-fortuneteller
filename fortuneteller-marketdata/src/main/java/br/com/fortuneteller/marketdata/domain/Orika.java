package br.com.fortuneteller.marketdata.domain;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class Orika {

	private MapperFacade mapper;

	public Orika() {
		MapperFactory factory = new DefaultMapperFactory.Builder().build();
		configureMappings(factory);
		mapper = factory.getMapperFacade();
	}

	private void configureMappings(MapperFactory factory) {
//		factory.classMap(MarketElementIndicator.class, DtoInsertMarketElementIndicator.class)
//				.constructorA().constructorB().mapNulls(true).mapNullsInReverse(false).byDefault()
//				.register();
	}

	public <S, D extends Serializable> D map(S sourceObject, Class<D> destinationClass) {
		validateObject(sourceObject, true);
		validateClass(destinationClass, false);
		return mapper.map(sourceObject, destinationClass);
	}

	public <S, D extends Serializable> D map(S sourceObject, D destinationObject) {

		validateObject(sourceObject, true);
		validateObject(destinationObject, false);

		destinationObject = SerializationUtils.clone(destinationObject);
		mapper.map(sourceObject, destinationObject);
		return destinationObject;
	}

	public Serializable mapObject(Serializable sourceObject, Class<? extends Serializable> destinationClass) {
		validateObject(sourceObject, true);
		validateClass(destinationClass, false);
		return mapper.map(sourceObject, destinationClass);
	}

	private <D extends Serializable> void validateClass(Class<D> clazz, boolean source) {
		if (!Serializable.class.isAssignableFrom(clazz)) {
			throw new RuntimeException(getPreffixSerializableError(source) + "Class must implements Serializable");
		}
	}

	private <S> void validateObject(S object, boolean source) {
		if (!(object instanceof Serializable)) {
			throw new RuntimeException(getPreffixSerializableError(source) + "Object must implements Serializable");
		}
	}

	private String getPreffixSerializableError(boolean source) {
		return source ? "Source" : "Destination";
	}

}