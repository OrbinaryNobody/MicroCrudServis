CREATE TABLE course.material (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title TEXT NOT NULL,
    type VARCHAR(50) NOT NULL,
    text_content TEXT,
    binary_content BYTEA,
    file_name TEXT,
    mime_type TEXT,
    file_size BIGINT,

    created TIMESTAMP NOT NULL DEFAULT now(),
    updated TIMESTAMP NOT NULL DEFAULT now(),

    CONSTRAINT check_material CHECK(
    (type = 'TEXT' AND text_content IS NOT NULL AND binary_content IS NULL)
    OR
    (type = ('IMAGE', 'FILE') AND binary_content IS NOT NULL)
    OR
    (type = 'VIDEO')
    )
);