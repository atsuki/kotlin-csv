package com.github.doyaaaaaken.kotlincsv.dsl

import io.kotlintest.specs.StringSpec
import com.github.doyaaaaaken.kotlincsv.client.CsvWriter
import com.github.doyaaaaaken.kotlincsv.dsl.context.WriteQuoteMode
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.shouldBe

/**
 * @author doyaaaaaken
 */
class CsvWriterDslTest : StringSpec({
    "csvWriter method should work as global method with no argument" {
        val writer = csvWriter()
        writer.shouldBeTypeOf<CsvWriter>()
    }
    "csvWriter method should work as dsl" {
        val writer = csvWriter {
            charset = Charsets.ISO_8859_1.name()
            delimiter = '\t'
            nullCode = "NULL"
            lineTerminator = "\n"
            outputLastLineTerminator = false
            quote {
                char = '\''
                mode = WriteQuoteMode.ALL
            }
        }
        writer.charset shouldBe Charsets.ISO_8859_1.name()
        writer.delimiter shouldBe '\t'
        writer.nullCode shouldBe "NULL"
        writer.lineTerminator shouldBe "\n"
        writer.outputLastLineTerminator shouldBe false
        writer.quote.char shouldBe '\''
        writer.quote.mode = WriteQuoteMode.ALL
    }
})
