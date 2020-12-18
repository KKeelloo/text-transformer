package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.DataContener;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;

/**
 * Klasa kontroloująca rzeczy związane z RESTem
 */

@RestController
public class TextTransformerController {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    /**
     * Metoda do obsługi wejścia w postaci textu i sekwencji transformacji (url w postaci adres serwera/text?transforms=sekwencja transformacji)
     * @param text tekst do transformacji
     * @param transforms sekwencja transformacji
     * @return parametry wywołania i wartość końcową
     */

    @RequestMapping(path = "/{text}",method = RequestMethod.GET, produces = "application/json")
    public EntityModel<DataContener> wejscie_tekst (@PathVariable String text,
                                         @RequestParam(value="transforms", defaultValue="upper") String[] transforms){

        logger.info(text);
        logger.info(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        DataContener data = new DataContener();
        data.setText(text);
        data.setTransforms(transforms);
        data.setReturn_val(transformer.transform(text));
        return EntityModel.of(data,
                linkTo(methodOn(TextTransformerController.class).wejscie_tekst(text, transforms)).withSelfRel());
    }

    /**
     * Metoda do obsługi wejścia w postaci jsona (url w postaci adres serwera, json w postaci {"text":"jakiś tekst", "transforms":[sekwencja transformacji]})
     * @param data zmapowany json
     * @return parametry wywołania i wartość końcową
     */

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public EntityModel<DataContener> wejscie_json(@RequestBody DataContener data){

        logger.info(data.getText());
        logger.info(Arrays.toString(data.getTransforms()));

        TextTransformer transformer = new TextTransformer(data.getTransforms());
        data.setReturn_val(transformer.transform(data.getText()));
        return EntityModel.of(data,
                linkTo(methodOn(TextTransformerController.class).wejscie_json(data)).withSelfRel());
    }



}


