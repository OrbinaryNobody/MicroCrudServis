CREATE TABLE course.track (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    track_constructor_id UUID
        REFERENCES course.track_constructor(id)
        ON DELETE SET NULL,

    title TEXT NOT NULL,

    -- полный текст / DSL курса
    full_text TEXT NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);
