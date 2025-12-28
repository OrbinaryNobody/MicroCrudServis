

CREATE SCHEMA course;

TABLE track_constructor (
  id UUID PK,
  name TEXT,
  description TEXT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

TABLE material (
  id UUID PK,
  title TEXT,
  type VARCHAR,
  content TEXT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

TABLE track (
  id UUID PK,
  track_constructor_id UUID FK,
  title TEXT,
  full_text TEXT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

TABLE track_material (
  track_id UUID FK,
  material_id UUID FK,
  position INT
);
