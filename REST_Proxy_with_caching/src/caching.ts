interface ICache {
  data: object;
  timestamp: number;
}

export class Caching {
  private static instance: Caching;
  private caching: ICache;

  constructor() {
    this.caching = { data: {}, timestamp: 0 };
  }

  public set(data: object) {
    this.caching = {
      data,
      timestamp: new Date().getTime(),
    };
  }

  public getCache(): ICache {
    return this.caching;
  }

  public getTimestamp(): number {
    return this.caching.timestamp;
  }

  // singleton instance
  public static getInstance(): Caching {
    if (!Caching.instance) {
      Caching.instance = new Caching();
    }
    return Caching.instance;
  }
}
