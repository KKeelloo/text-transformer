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


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(path = "/{text}",method = RequestMethod.GET, produces = "application/json")
    public EntityModel<DataContener> wejscie_tekst (@PathVariable String text,
                                         @RequestParam(value="transforms", defaultValue="upper") String[] transforms){
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        DataContener data = new DataContener();
        data.setText(text);
        data.setTransforms(transforms);
        data.setReturn_val(transformer.transform(text));
        return EntityModel.of(data,
                linkTo(methodOn(TextTransformerController.class).wejscie_tekst(text, transforms)).withSelfRel());
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public EntityModel<DataContener> wejscie_json(@RequestBody DataContener data){

        // log the parameters
        logger.debug(data.getText());
        logger.debug(Arrays.toString(data.getTransforms()));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(data.getTransforms());
        data.setReturn_val(transformer.transform(data.getText()));
        return EntityModel.of(data,
                linkTo(methodOn(TextTransformerController.class).wejscie_json(data)).withSelfRel());
    }



}


