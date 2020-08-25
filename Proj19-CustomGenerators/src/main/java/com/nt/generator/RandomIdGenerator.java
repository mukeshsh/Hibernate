package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator {
	public RandomIdGenerator() {
      System.out.println("RandomIdGenerator::0-param Constructor");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
     System.out.println("RandomIdGenerator.generate()");
     int idVal=0;
     idVal=new Random().nextInt(10000);
		return idVal;
	}

}
