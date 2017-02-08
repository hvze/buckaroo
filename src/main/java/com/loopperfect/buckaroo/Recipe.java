package com.loopperfect.buckaroo;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Objects;

public final class Recipe {

    public final Identifier name;
    public final String url;
    public final ImmutableMap<SemanticVersion, RecipeVersion> versions;

    private Recipe(final Identifier name, final String url, final ImmutableMap<SemanticVersion, RecipeVersion> versions) {

        super();

        this.name = Preconditions.checkNotNull(name);
        this.url = Preconditions.checkNotNull(url);
        this.versions = Preconditions.checkNotNull(versions);
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == null || !(obj instanceof Recipe)) {
            return false;
        }

        final Recipe other = (Recipe) obj;

        return Objects.equals(name, other.name) &&
                Objects.equals(url, other.url) &&
                Objects.equals(versions, other.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, versions);
    }

    public static Recipe of(final Identifier name, final String url, final ImmutableMap<SemanticVersion, RecipeVersion> versions) {
        return new Recipe(name, url, versions);
    }
}