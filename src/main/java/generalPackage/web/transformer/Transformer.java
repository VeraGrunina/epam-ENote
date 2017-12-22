package generalPackage.web.transformer;

/**
 * interface to convert model from front-end to entities for database
 */
public interface Transformer<S, D> {

    /**
     * transform entity to model
     */
    D unbind(S source);

    /**
     * bind model with entity
     */
    S bind(D source);
}
