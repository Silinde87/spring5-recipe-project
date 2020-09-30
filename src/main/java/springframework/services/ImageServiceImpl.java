package springframework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import springframework.domain.Recipe;
import springframework.repositories.RecipeRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try{
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            //Converting primitive byte array into his wrapper.
            int i = 0;
            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);

        }catch(IOException e){
            //todo handle better
            log.debug("Error occurred", e);

            e.printStackTrace();
        }


    }
}
