package io.prediction.engines.java.itemrec;

import io.prediction.engines.java.itemrec.data.TrainingData;
import io.prediction.engines.java.itemrec.data.Query;
import io.prediction.engines.java.itemrec.data.Prediction;
import io.prediction.engines.java.itemrec.data.Actual;
import io.prediction.engines.java.itemrec.algos.GenericItemBased;
import io.prediction.engines.java.itemrec.algos.SVDPlusPlus;

import io.prediction.controller.IEngineFactory;
import io.prediction.controller.EmptyParams;
import io.prediction.controller.java.JavaEngine;
import io.prediction.controller.java.JavaEngineBuilder;

public class EngineFactory implements IEngineFactory {
  public JavaEngine<TrainingData, EmptyParams, TrainingData, Query, Prediction, Actual> apply() {
    return new JavaEngineBuilder<
      TrainingData, EmptyParams, TrainingData, Query, Prediction, Actual>()
      .dataSourceClass(ItemRecDataSource.class)
      .preparatorClass(ItemRecPreparator.class)
      .addAlgorithmClass("genericitembased", GenericItemBased.class)
      .addAlgorithmClass("svdplusplus", SVDPlusPlus.class)
      .servingClass(ItemRecServing.class)
      .build();
  }
}
