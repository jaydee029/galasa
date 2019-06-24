package dev.voras.common.artifact;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.voras.common.artifact.internal.ArtifactManagerField;
import dev.voras.framework.spi.ValidAnnotatedFields;

/**
 * Used to annotate annotations that are to be used for Test Class fields. To be
 * populated by the Manager.
 *
 * @author William Yates
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@ValidAnnotatedFields({ IArtifactManager.class })
@ArtifactManagerField
public @interface ArtifactManager {

}
