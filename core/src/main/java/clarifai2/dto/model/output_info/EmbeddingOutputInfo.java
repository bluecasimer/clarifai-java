package clarifai2.dto.model.output_info;

import clarifai2.internal.grpc.api.ModelOuterClass;
import clarifai2.exception.ClarifaiException;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NullableProblems")
@AutoValue
public abstract class EmbeddingOutputInfo extends OutputInfo {

  EmbeddingOutputInfo() {} // AutoValue instances only

  @NotNull public abstract String type();

  @NotNull public abstract String typeExt();

  @Override @NotNull public ModelOuterClass.OutputInfo serialize() {
    throw new ClarifaiException(this.getClass().getSimpleName() + " is not serializable");
  }

  @NotNull public static EmbeddingOutputInfo deserializeInner(ModelOuterClass.OutputInfo outputInfo) {
    return new AutoValue_EmbeddingOutputInfo(outputInfo.getType(), outputInfo.getTypeExt());
  }
}