package com.tsanta.storedint.file.hash;

import com.tsanta.storedint.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
