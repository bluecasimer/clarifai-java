package clarifai2.integration_tests;

import clarifai2.api.ClarifaiResponse;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Color;
import clarifai2.dto.prediction.Concept;
import clarifai2.dto.prediction.Embedding;
import clarifai2.dto.prediction.FaceConcepts;
import clarifai2.dto.prediction.FaceDetection;
import clarifai2.dto.prediction.FaceEmbedding;
import clarifai2.dto.prediction.Logo;
import clarifai2.dto.prediction.Region;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VariousModelsIntTests extends BaseIntTest {

  @Test public void shouldBeSuccessfulForModerationModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response = client.getDefaultModels().moderationModel().predict()
        .withInputs(ClarifaiInput.forImage(METRO_NORTH_IMAGE_URL)).executeSync();
    assertSuccess(response);

    List<Concept> concepts = response.get().get(0).data();
    assertNotNull(concepts);
    assertTrue(concepts.size() > 0);
  }

  @Test public void shouldBeCorrectForFoodModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response = client.getDefaultModels().foodModel().predict()
        .withInputs(ClarifaiInput.forImage(FOOD_IMAGE_URL)).executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).id());
  }

  @Test public void shouldBeCorrectForApparelModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response = client.getDefaultModels().apparelModel().predict()
        .withInputs(ClarifaiInput.forImage(SUNGLASSES_IMAGE_URL))
        .executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeSuccessfulForLandscapeQualityModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response =
        client.getDefaultModels().landscapeQualityModel().predict()
        .withInputs(ClarifaiInput.forImage(METRO_NORTH_IMAGE_URL)).executeSync();
    assertSuccess(response);
    List<Concept> concepts = response.get().get(0).data();
    assertNotNull(concepts);
    assertTrue(concepts.size() > 0);
  }

  @Test public void shouldBeSuccessfulForPortraitQualityModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response =
        client.getDefaultModels().portraitQualityModel().predict()
        .withInputs(ClarifaiInput.forImage(METRO_NORTH_IMAGE_URL)).executeSync();
    assertSuccess(response);
    List<Concept> concepts = response.get().get(0).data();
    assertNotNull(concepts);
    assertTrue(concepts.size() > 0);
  }

  @Test public void shouldBeSuccessfulForTexturesAndPatternsModel() {
    ClarifaiResponse<List<ClarifaiOutput<Concept>>> response =
        client.getDefaultModels().texturesAndPatternsModel().predict()
        .withInputs(ClarifaiInput.forImage(METRO_NORTH_IMAGE_URL)).executeSync();
    assertSuccess(response);
    List<Concept> concepts = response.get().get(0).data();
    assertNotNull(concepts);
    assertTrue(concepts.size() > 0);
  }

  @Test public void shouldBeCorrectForLogoModel() {
    ClarifaiResponse<List<ClarifaiOutput<Logo>>> response = client.getDefaultModels().logoModel().predict()
        .withInputs(ClarifaiInput.forImage(LOGO_IMAGE_URL)).executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeCorrectForColorModel() {
    ClarifaiResponse<List<ClarifaiOutput<Color>>> response = client.getDefaultModels().colorModel().predict()
        .withInputs(ClarifaiInput.forImage(LOGO_IMAGE_URL)).executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeCorrectForFaceDetectionModel() {
    ClarifaiResponse<List<ClarifaiOutput<FaceDetection>>> response = client.getDefaultModels().faceDetectionModel()
        .predict()
        .withInputs(ClarifaiInput.forImage(CELEBRITY_IMAGE_URL))
        .executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeCorrectForDemographicsModel() {
    ClarifaiResponse<List<ClarifaiOutput<Region>>> response = client.getDefaultModels().demographicsModel().predict()
        .withInputs(ClarifaiInput.forImage(STREETBAND_IMAGE_URL))
        .executeSync();
    assertSuccess(response);
    Region region = response.get().get(0).data().get(0);
    assertNotNull(region.crop());
    assertNotNull(region.multiculturalAppearances().get(0).name());
    assertNotNull(region.genderAppearances().get(0).name());
    assertNotNull(region.ageAppearances().get(0).name());
  }

  @Test public void shouldBeCorrectForFaceConceptsModel() {
    ClarifaiResponse<List<ClarifaiOutput<FaceConcepts>>> response = client.getDefaultModels().celebrityModel()
        .predict()
        .withInputs(ClarifaiInput.forImage(CELEBRITY_IMAGE_URL)).executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeCorrectForGeneralEmbeddingModel() {
    ClarifaiResponse<List<ClarifaiOutput<Embedding>>> response =
        client.getDefaultModels().generalEmbeddingModel().predict()
            .withInputs(ClarifaiInput.forImage(CELEBRITY_IMAGE_URL))
            .executeSync();
    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeSuccessfulForDemographicsModel() {
    ClarifaiResponse<List<ClarifaiOutput<Region>>> response =
        client.getDefaultModels().demographicsModel().predict()
            .withInputs(ClarifaiInput.forImage(CELEBRITY_IMAGE_URL))
            .executeSync();

    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeSuccessfulForFaceDetectionModel() {
    ClarifaiResponse<List<ClarifaiOutput<FaceDetection>>> response =
        client.getDefaultModels().faceDetectionModel().predict()
            .withInputs(ClarifaiInput.forImage(CELEBRITY_IMAGE_URL))
            .executeSync();

    assertSuccess(response);
    assertNotNull(response.get().get(0).data().get(0));
  }

  @Test public void shouldBeSuccessfulForFaceEmbeddingsModel() {
    ClarifaiResponse<List<ClarifaiOutput<FaceEmbedding>>> response = client.getDefaultModels().faceEmbeddingModel()
        .predict()
        .withInputs(ClarifaiInput.forImage(FAMILY_IMAGE_URL))
        .executeSync();

    assertSuccess(response);
    assertNotNull(response.get());
    assertNotNull(response.get().get(0));
    List<FaceEmbedding> embeddings = response.get().get(0).data();
    assertNotNull(embeddings);
    assertNotNull(embeddings.get(0));
    assertNotNull(embeddings.get(0).embeddings());
  }
}
