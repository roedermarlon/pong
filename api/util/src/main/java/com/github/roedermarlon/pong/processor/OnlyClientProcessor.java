package com.github.roedermarlon.pong.processor;

import com.github.roedermarlon.pong.api.util.OnlyClient;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("com.github.roedermarlon.pong.api.util.OnlyClient")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
// TODO
public class OnlyClientProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(OnlyClient.class);

        for (TypeElement annotatedClass : ElementFilter.typesIn(annotatedElements)) {
            for (Element enclosedElement : annotatedClass.getEnclosedElements()) {
                if (enclosedElement.getKind() == ElementKind.FIELD || enclosedElement.getKind() == ElementKind.METHOD) {
                    TypeElement enclosingClass = (TypeElement) enclosedElement.getEnclosingElement();
                    if (enclosingClass.getAnnotationMirrors().stream()
                            .noneMatch(annotation -> annotation.getAnnotationType().toString().equals(OnlyClient.class.getName()))) {
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                "Class " + enclosingClass.getQualifiedName() + " uses @OnlyClient annotated class " +
                                        annotatedClass.getQualifiedName() + " but is not annotated with @OnlyClient.");
                    }
                }
            }
        }
        return true;
    }
}